package com.blog.app.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.blog.app.enitity.Category;

public interface CategoryRepo extends JpaRepository<Category, Integer> {

}
