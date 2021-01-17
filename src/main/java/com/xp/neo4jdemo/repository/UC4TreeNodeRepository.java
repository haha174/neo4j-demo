package com.xp.neo4jdemo.repository;


import com.xp.neo4jdemo.domain.UC4TreeNode;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UC4TreeNodeRepository extends Neo4jRepository<UC4TreeNode,String>{

}
