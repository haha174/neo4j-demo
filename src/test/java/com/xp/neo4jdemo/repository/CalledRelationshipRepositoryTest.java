package com.xp.neo4jdemo.repository;

import com.xp.neo4jdemo.Neo4jDemoApplicationTests;
import com.xp.neo4jdemo.domain.CalledUC4Relationship;
import com.xp.neo4jdemo.domain.UC4TreeNode;
import org.junit.Test;
import org.neo4j.ogm.session.Session;
import org.neo4j.ogm.session.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.neo4j.ogm.model.Result;

import java.util.HashMap;

@Component
public class CalledRelationshipRepositoryTest extends Neo4jDemoApplicationTests {
    Logger logger = LoggerFactory.getLogger(CalledRelationshipRepositoryTest.class);
    @Autowired
    CalledUC4RelationshipRepository calledUC4RelationshipRepository;

    @Autowired
    UC4TreeNodeRepository uc4TreeNodeRepository;

    @Autowired
    SessionFactory sessionFactory;

    @Test
    public void test() {
        UC4TreeNode uc4TreeNode1 = new UC4TreeNode();
        uc4TreeNode1.setId("10");
        uc4TreeNode1.setName("STE_HERMES");
        uc4TreeNode1.setProcess("ksh dw_clsfd.clsfd_ste.ksh");
        uc4TreeNode1.setTitle("hermes ste");
        uc4TreeNodeRepository.save(uc4TreeNode1);

        UC4TreeNode uc4TreeNode2 = new UC4TreeNode();
        uc4TreeNode2.setId("11");
        uc4TreeNode2.setName("STT_HERMES");
        uc4TreeNode2.setProcess("ksh dw_clsfd.clsfd_stt.ksh");
        uc4TreeNode2.setTitle("hermes stt");
        uc4TreeNodeRepository.save(uc4TreeNode2);


        CalledUC4Relationship calledRelationship = new CalledUC4Relationship();
        calledRelationship.setId("STE_HERMES->STT_HERMES");
        calledRelationship.setStartNode(uc4TreeNode1);
        calledRelationship.setEndNode(uc4TreeNode2);
        calledUC4RelationshipRepository.save(calledRelationship);
    }

    @Test
    public void updateNode() {
        UC4TreeNode uc4TreeNode1 = new UC4TreeNode();
        uc4TreeNode1.setId("10");
        uc4TreeNode1.setName("STE_HERMES");
        uc4TreeNode1.setProcess("ksh dw_clsfd.clsfd_ste.ksh");
        uc4TreeNode1.setTitle("hermes ste updated");
        uc4TreeNodeRepository.save(uc4TreeNode1);
    }

    @Test
    public void deleteRelation() {
        calledUC4RelationshipRepository.deleteById("STE_HERMES->STT_HERMES");
    }

    @Test
    public void fild() {
        Session session = sessionFactory.openSession();
        String cypher="MATCH (name:uc4node) RETURN name LIMIT 25";
        Result result= session.query(cypher, new HashMap<>(), false);
        System.out.println(result);
    }
}