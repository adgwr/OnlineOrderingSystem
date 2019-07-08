package com.adgwr.online.ordering.system.admin.controller;

import com.adgwr.online.ordering.system.admin.service.CategoryService;
import com.adgwr.online.ordering.system.admin.service.FoodBelongService;
import com.adgwr.online.ordering.system.admin.service.FoodService;
import com.adgwr.online.ordering.system.domain.Category;
import com.adgwr.online.ordering.system.domain.Food;
import com.adgwr.online.ordering.system.domain.FoodBelong;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;

/**
 * @author Tracy
 */
@Controller
public class FoodController {
    @Autowired
    private FoodService foodService;

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private FoodBelongService foodBelongService;

    @RequestMapping(value = "admin/food/foodDisplay", method = RequestMethod.GET)
    public String turnFoodDisplay(Model model){
        List<Food> foodList = foodService.getAllFood();
        model.addAttribute("foodList",foodList);
        return "admin/food/foodDisplay";
    }

    @RequestMapping(value = "admin/food/turnFoodAdd", method = RequestMethod.GET)
    public String turnFoodAdd(){
        return "admin/food/foodAdd";
    }

    @RequestMapping(value = "admin/food/foodAdd", method = RequestMethod.POST)
    public String foodAdd(String foodName,
                          String foodSubName,
                          BigDecimal foodPrice,
                          String foodDesc,
                          @RequestParam("file") MultipartFile file,
                          Model model){//1. 接受上传的文件  @RequestParam("file") MultipartFile file
        try {
            //2.根据时间戳创建新的文件名，这样即便是第二次上传相同名称的文件，也不会把第一次的文件覆盖了
            String fileName = System.currentTimeMillis() + file.getOriginalFilename();
            //3.通过request.getServletContext().getRealPath("") 获取当前项目的真实路径，然后拼接前面的文件名
//            String destFileName = request.getServletContext().getRealPath("") + "foodImage" + File.separator + fileName;
            String destFileName = ResourceUtils.getURL("classpath:").getPath()+"static/foodImage/" + fileName;
            //4.第一次运行的时候，这个文件所在的目录往往是不存在的，这里需要创建一下目录（创建到了webapp下uploaded文件夹下）
            File destFile = new File(destFileName);
            destFile.getParentFile().mkdirs();
            //5.把浏览器上传的文件复制到希望的位置
            file.transferTo(destFile);
            //6.把文件名放在model里，以便后续显示用
            foodService.addFood(foodName,foodSubName,fileName,foodPrice,foodDesc);
//            model.addAttribute("fileName", fileName);
            turnFoodDisplay(model);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return "上传失败," + e.getMessage();
        } catch (IOException e) {
            e.printStackTrace();
            return "上传失败," + e.getMessage();
        }
        return "admin/food/foodDisplay";
    }

    @RequestMapping(value = "admin/food/foodDelete", method = RequestMethod.GET)
    public String foodDelete(String fId, Model model){
        int id = Integer.parseInt(fId);
        foodService.deleteFood(id);
        turnFoodDisplay(model);
        return "admin/food/foodDisplay";
    }

    @RequestMapping(value = "admin/food/turnFoodEdit", method = RequestMethod.GET)
    public String turnFoodEdit(String oldFoodId, Model model){
        Food oldFood = new Food();
        int id = Integer.parseInt(oldFoodId);
        oldFood = foodService.getFoodById(id);
        model.addAttribute("oldFood", oldFood);
        return "admin/food/foodEdit";
    }

    @RequestMapping(value = "admin/food/foodEdit", method = RequestMethod.POST)
    public String foodEdit(Integer foodId,
                           String foodName,
                           String foodSubName,
                           BigDecimal foodPrice,
                           String foodDesc,
                           @RequestParam("file") MultipartFile file,
                           Model model){
        try {
            Food food = foodService.getFoodById(foodId);
            food.setFdName(foodName);
            food.setFdSubname(foodSubName);
            food.setFdPrice(foodPrice);
            food.setFdDescription(foodDesc);
            String fileName = System.currentTimeMillis() + file.getOriginalFilename();
            String destFileName = ResourceUtils.getURL("classpath:").getPath()+"static/foodImage/" + fileName;
            //4.第一次运行的时候，这个文件所在的目录往往是不存在的，这里需要创建一下目录（创建到了webapp下uploaded文件夹下）
            File destFile = new File(destFileName);
            destFile.getParentFile().mkdirs();
            //5.把浏览器上传的文件复制到希望的位置
            file.transferTo(destFile);
            food.setFdImage(fileName);
            foodService.updateFood(food);
            turnFoodDisplay(model);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return "上传失败," + e.getMessage();
        } catch (IOException e) {
            e.printStackTrace();
            return "上传失败," + e.getMessage();
        }
        return "admin/food/foodDisplay";
    }

    @RequestMapping(value = "admin/food/turnCategoryEdit", method = RequestMethod.GET)
    public String turnCategoryEdit(Integer food, Model model){
        Food oldFood = foodService.getFoodById(food);
        model.addAttribute("foodForCategory",oldFood);
        List<Category> categoryList = categoryService.getAllCategory();
        model.addAttribute("categoryList",categoryList);
        return "admin/food/foodCategoryEdite";
    }

    @RequestMapping(value = "admin/food/categoryEdit", method = RequestMethod.GET)
    public String categoryEdit(Integer foodId, int[] item, Model model){
        foodBelongService.deleteFoodBelong(foodId);
        for(int i = 0; i < item.length; i++){
            foodBelongService.addFoodBelong(foodId, item[i]);
        }
        turnFoodDisplay(model);
        return "admin/food/foodDisplay";
    }

    @RequestMapping(value = "admin/food/foodSearch", method = RequestMethod.GET)
    public String foodSearch(String info, Model model){
        List<Food> foodSearchResult = foodService.getFoodByName(info);
        model.addAttribute("foodSearchResult",foodSearchResult);
        return "admin/food/foodSearchResult";
    }
}
