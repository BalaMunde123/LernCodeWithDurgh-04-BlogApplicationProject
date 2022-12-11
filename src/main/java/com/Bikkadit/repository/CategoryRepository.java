package com.Bikkadit.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Bikkadit.entities.Category;
@Repository
public interface CategoryRepository extends JpaRepository<Category, Integer>{

}
