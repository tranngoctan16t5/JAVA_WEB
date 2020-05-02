package com.admin.app.repository;

import com.admin.app.model.Blog;
import com.admin.app.model.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface BlogRepository extends PagingAndSortingRepository<Blog,Long>
{
    Page<Blog> findAllByCategory (Pageable pageable, Category category);
    //Page<Blog> findAllOrderByDateCreatedDesc(Pageable pageable);
    @Query( "select b from Blog b order by b.dateCreated " )
    Page<Blog> findAllThenOrderByDateCreated(Pageable pageable);
    //Iterable<Blog> finAllThenSortByDateCreated(); //findAllSortByDateCreated
    Page<Blog> findAllByContent(Pageable pageable,String content);
    @Query("select b from Blog b where b.title like %?1%")
    Page<Blog> findAllWhereTitleBelike(Pageable pageable,String title);
}
