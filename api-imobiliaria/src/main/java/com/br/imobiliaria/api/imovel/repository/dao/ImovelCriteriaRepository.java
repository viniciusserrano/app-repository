//package com.br.imobiliaria.api.imovel.repository.dao;
//
//import com.br.imobiliaria.api.imovel.repository.dto.ImovelResponseDto;
//import com.br.imobiliaria.api.imovel.repository.entity.ImovelEntity;
//import com.br.imobiliaria.api.imovel.service.converter.ImovelConverter;
//import com.mongodb.client.MongoCollection;
//import org.bson.BsonInt64;
//import org.bson.Document;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.data.mongodb.core.MongoTemplate;
//import org.springframework.data.mongodb.core.convert.MappingMongoConverter;
//import org.springframework.data.mongodb.core.query.BasicQuery;
//import org.springframework.data.mongodb.core.query.Criteria;
//import org.springframework.data.mongodb.core.query.Query;
//import org.springframework.http.HttpStatus;
//import org.springframework.stereotype.Repository;
//import org.springframework.web.server.ResponseStatusException;
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Optional;
//
//@Repository
//public class ImovelCriteriaRepository {
//    private final MongoTemplate mongoTemplate;
//    private final ImovelConverter imovelConverter;
//    private final ImovelDao imovelDao;
//
//    private static final Logger log = LoggerFactory.getLogger(ImovelCriteriaRepository.class);
//
//    public ImovelCriteriaRepository(MongoTemplate mongoTemplate,ImovelConverter imovelConverter,
//                                    ImovelDao imovelDao) {
//        this.mongoTemplate = mongoTemplate;
//        this.imovelConverter = imovelConverter;
//        this.imovelDao = imovelDao;
//    }
//
//    /**
//     * Debug geral: faz 4 buscas diferentes e imprime os primeiros 5 docs
//     */
//    public void debugConsultas(Long idImovel) {
//        System.out.println(">>> DEBUG debugConsultas para idImovel = " + idImovel);
//
//        // 0) Busca com Long (BsonInt64) – este é o mais importante
//        Query qLong = Query.query(Criteria.where("idImovel").is(idImovel));
//        System.out.println("0) Query Long: " + qLong.getQueryObject());
//        ImovelEntity resLong = mongoTemplate.findOne(qLong, ImovelEntity.class);
//        System.out.println("   → Resultado Long: " + resLong);
//
//        // 1) Busca com Int32
//        int id32 = idImovel.intValue();
//        Query qInt32 = Query.query(Criteria.where("idImovel").is(id32));
//        System.out.println("1) Query Int32: " + qInt32.getQueryObject());
//        ImovelEntity resInt32 = mongoTemplate.findOne(qInt32, ImovelEntity.class);
//        System.out.println("   → Resultado Int32: " + resInt32);
//
//        // 2) BasicQuery raw JSON (pode falhar por tipo ambíguo)
//        String json = "{ \"idImovel\" : " + idImovel + " }";
//        BasicQuery qRaw = new BasicQuery(json);
//        System.out.println("2) BasicQuery raw JSON: " + json);
//        ImovelEntity resRaw = mongoTemplate.findOne(qRaw, ImovelEntity.class);
//        System.out.println("   → Resultado BasicQuery: " + resRaw);
//
//        // 3) Lista primeiros 5 documentos e imprime o tipo Java do campo
//        System.out.println("3) Amostra dos primeiros 5 docs:");
//        List<ImovelEntity> primeiros = mongoTemplate.find(new Query().limit(5), ImovelEntity.class);
//        primeiros.forEach(doc ->
//                System.out.println("   _id Mongo = " + doc.getId() +
//                        " | idImovel(field) = " + doc.getIdImovel() +
//                        " (" + (doc.getIdImovel() != null
//                        ? doc.getIdImovel().getClass().getSimpleName()
//                        : "null") + ")")
//        );
//    }
//
//    public void superDebug(Long idImovel) {
//        // 0) Banco/coleção
//        System.out.println(">>> DB = " + mongoTemplate.getDb().getName());
//        mongoTemplate.getDb()
//                .listCollectionNames()
//                .forEach(c -> System.out.println("    Collection: " + c));
//
//        // 1) Lista **todos** os idImovel via template (não só 5 primeiros):
//        System.out.println(">>> findAll via template, buscando idImovel == " + idImovel);
//        List<ImovelEntity> all = mongoTemplate.findAll(ImovelEntity.class);
//        boolean found = false;
//        for (ImovelEntity e : all) {
//            if (idImovel.equals(e.getIdImovel())) {
//                System.out.println("    ∙ Encontrado em findAll: " + e);
//                found = true;
//            }
//        }
//        System.out.println("    → achou no findAll? " + found);
//
//        // 2) Distinct dos valores de idImovel na coleção:
//        MongoCollection<Document> coll = mongoTemplate.getCollection("imoveis");
//        List<Long> distinct = coll
//                .distinct("idImovel", Long.class)
//                .into(new ArrayList<>());
//        System.out.println(">>> distinct idImovel (" + distinct.size() + "): " + distinct);
//
//        // 3) Query pura para Document:
//        Document qDoc = new Document("idImovel", idImovel);
//        Document rawDoc = coll.find(qDoc).first();
//        System.out.println(">>> find raw Document by idImovel: " + rawDoc);
//
//        // 4) Query via mongoTemplate buscando Document:
//        Document viaTemplate = mongoTemplate.findOne(
//                Query.query(Criteria.where("idImovel").is(idImovel)),
//                Document.class,
//                "imoveis"
//        );
//        System.out.println(">>> findOne via template para Document: " + viaTemplate);
//
//        // 5) Índices da coleção
//        Document idxs = mongoTemplate.getDb()
//                .runCommand(new Document("listIndexes", "imoveis"));
//        System.out.println(">>> Indexes: " + idxs.toJson());
//    }
//
//    /** Busca única por idImovel (campo de negócio) */
////    public ImovelResponseDto buscarPorId(Long idImovel) {
////        // 1) Pega a coleção via driver "puro"
////        MongoCollection<Document> coll = mongoTemplate.getCollection("imoveis");
////
////        // 2) Executa exatamente a mesma query do Compass
////        Document filtro = new Document("idImovel", idImovel);
////        Document raw = coll.find(filtro).first();
////
////        if (raw == null) {
////            throw new ResponseStatusException(
////                    HttpStatus.NOT_FOUND,
////                    "Imóvel não encontrado. id: " + idImovel
////            );
////        }
////
////        // (Opcional) debug do Document cru:
////        System.out.println(">>> RAW DOC: " + raw.toJson());
////
////        // 3) Converte Document para sua entidade via MappingMongoConverter interno
////        ImovelEntity entity = mongoTemplate.getConverter()
////                .read(ImovelEntity.class, raw);
////
////        // 4) Debug de segmentos
////        System.out.println(">>> DEBUG ENTITY: segmentoVenda="
////                + entity.getSegmentoVenda()
////                + " segmentoLocacao="
////                + entity.getSegmentoLocacao());
////
////        // 5) Aplica sua regra de negócio de segmentos
////        if (!Integer.valueOf(1).equals(entity.getSegmentoVenda())
////                && !Integer.valueOf(1).equals(entity.getSegmentoLocacao())) {
////            throw new ResponseStatusException(
////                    HttpStatus.NOT_FOUND,
////                    "Imóvel não encontrado ou sem segmento válido. id: " + idImovel
////            );
////        }
////
////        // 6) Converte para DTO e retorna
////        return imovelConverter.paraDto(entity);
////    }
//    public ImovelResponseDto buscarPorId(Long idImovel) {
//        // para converter Document→Entity “na mão”
//        MappingMongoConverter converter = (MappingMongoConverter) mongoTemplate.getConverter();
//        MongoCollection<Document> coll = mongoTemplate.getCollection("imoveis");
//
//        // 1) find by _id (String)
//        String oid = "633fd8fb430fc93989eaadd7"; // substitua pelo _id real
//        ImovelEntity e1 = mongoTemplate.findOne(
//                Query.query(Criteria.where("_id").is(oid)),
//                ImovelEntity.class
//        );
//        System.out.println("1) findBy _id               → " + e1);
//
//        // 2) BasicQuery JSON puro
//        BasicQuery q2 = new BasicQuery("{ \"idImovel\": " + idImovel + " }");
//        ImovelEntity e2 = mongoTemplate.findOne(q2, ImovelEntity.class);
//        System.out.println("2) BasicQuery                → " + e2);
//
//        // 3) Criteria padrão (Long)
//        Query qLong = Query.query(Criteria.where("idImovel").is(idImovel));
//        ImovelEntity e3 = mongoTemplate.findOne(qLong, ImovelEntity.class);
//        System.out.println("3) Criteria Long             → " + e3);
//
//        // 4) Criteria forçando BsonInt64
//        Query q64 = Query.query(Criteria.where("idImovel").is(new BsonInt64(idImovel)));
//        ImovelEntity e4 = mongoTemplate.findOne(q64, ImovelEntity.class);
//        System.out.println("4) Criteria BsonInt64        → " + e4);
//
//        // 5) Driver puro: Document via find()
//        Document doc5 = coll.find(new Document("idImovel", idImovel)).first();
//        System.out.println("5) Driver.find Document      → " + doc5);
//
//        // 6) Converter esse Document “na mão”
//        ImovelEntity e6 = null;
//        if (doc5 != null) {
//            try {
//                e6 = converter.read(ImovelEntity.class, doc5);
//            } catch (Exception ex) {
//                System.err.println("   > falha na conversão manual: " + ex.getMessage());
//            }
//        }
//        System.out.println("6) Manual converter          → " + e6);
//
//        // 7) Template.execute → Document cru
//        Document doc7 = mongoTemplate.execute("imoveis", c ->
//                c.find(new Document("idImovel", idImovel)).first()
//        );
//        System.out.println("7) Template.execute→Document → " + doc7);
//
//        // 8) Sua busca “oficial”, mapeando direto pra ImovelEntity
//        ImovelEntity e8 = mongoTemplate.findOne(q64, ImovelEntity.class);
//        System.out.println("8) Resultado final           → " + e8);
//
//        if (e8 == null) {
//            throw new ResponseStatusException(
//                    HttpStatus.NOT_FOUND,
//                    "Imóvel não encontrado. id: " + idImovel
//            );
//        }
//
//        // 9) Converte e retorna DTO
//        return imovelConverter.paraDto(e8);
//    }
//
//
//
//    /** Conta quantos têm aquele idImovel */
//    public long countByIdImovel(Long idImovel) {
//        System.out.println(">>> countByIdImovel - iniciando para idImovel = " + idImovel);
//        Query query = Query.query(Criteria.where("idImovel").is(idImovel));
//        System.out.println("    Query JSON: " + query);
//        long count = mongoTemplate.count(query, ImovelEntity.class);
//        System.out.println("    Total encontrado: " + count);
//        return count;
//    }
//
//    /** Busca por segmentoVenda ou segmentoLocacao */
//    public List<ImovelEntity> findBySegmentoVendaOrLocacao(Integer segVenda, Integer segLocacao) {
//        System.out.println(">>> findBySegmentoVendaOrLocacao - segVenda=" + segVenda + ", segLocacao=" + segLocacao);
//        Query query = Query.query(new Criteria().orOperator(
//                Criteria.where("segmentoVenda").is(segVenda),
//                Criteria.where("segmentoLocacao").is(segLocacao)
//        ));
//        System.out.println("    Query JSON: " + query);
//        List<ImovelEntity> lista = mongoTemplate.find(query, ImovelEntity.class);
//        System.out.println("    Resultado size: " + lista.size());
//        return lista;
//    }
//}
