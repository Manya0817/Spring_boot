package com.module4.productionReadyFeatures.productionReadyFeatures.repositories;

import com.module4.productionReadyFeatures.productionReadyFeatures.entities.PostEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends JpaRepository<PostEntity,Long> {
}
