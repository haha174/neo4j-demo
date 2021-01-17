package com.xp.neo4jdemo.repository;


import com.xp.neo4jdemo.domain.CalledUC4Relationship;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CalledUC4RelationshipRepository extends Neo4jRepository<CalledUC4Relationship,String>{

}
