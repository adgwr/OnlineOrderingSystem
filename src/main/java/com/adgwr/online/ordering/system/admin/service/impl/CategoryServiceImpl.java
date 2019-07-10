package com.adgwr.online.ordering.system.admin.service.impl;

import com.adgwr.online.ordering.system.admin.service.CategoryService;
import com.adgwr.online.ordering.system.domain.AdminAccount;
import com.adgwr.online.ordering.system.domain.Category;
import com.adgwr.online.ordering.system.mapper.AdminAccountMapper;
import com.adgwr.online.ordering.system.mapper.CategoryMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
 * @Author Tracy
 */
@Service
@Transactional(readOnly = false)
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    private CategoryMapper categoryMapper;

    @Override
    public void addCategory(String categoryName){
        Category category = new Category();
        category.setCategoryName(categoryName);
        categoryMapper.insert(category);
    }

    @Override
    public void deleteCategory(int categoryId){
        Example example=new Example(Category.class);
        example.createCriteria().andEqualTo("categoryId",categoryId);
        //从数据查询
        Category category = categoryMapper.selectOneByExample(example);
        categoryMapper.delete(category);
    }

    @Override
    public void updateCategory(Category category){
        categoryMapper.updateByPrimaryKey(category);
    }

    @Override
    public Category getCategoryById(int categoryId){

        Example example=new Example(Category.class);
        example.createCriteria().andEqualTo("categoryId",categoryId);
        //从数据查询
        Category category = categoryMapper.selectOneByExample(example);
        return category;
    }

    @Override
    public List<Category> getAllCategory(){
        return categoryMapper.selectAll();
    }
}
