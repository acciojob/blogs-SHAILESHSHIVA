package com.driver.services;

import com.driver.models.*;
import com.driver.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ImageService {

    @Autowired
    BlogRepository blogRepository2;
    @Autowired
    ImageRepository imageRepository2;

    public Image addImage(Integer blogId, String description, String dimensions) {
        //add an image to the blog
//        if(!blogRepository2.findById(blogId).isPresent()) {
//            throw new Exception();
//        }
        Blog blog = blogRepository2.findById(blogId).get();
        Image image = new Image(blog,description,dimensions);
        blog.getImageList().add(image);
        blogRepository2.save(blog);
        return image;
        //Here I am not explicitly adding image in image-repository because due to cascading effect
    }

    public void deleteImage(Integer id){
        imageRepository2.deleteById(id);
    }

    public int countImagesInScreen(Integer id, String screenDimensions) {
        //Find the number of images of given dimensions that can fit in a screen having `screenDimensions`
        String[] screen = screenDimensions.split("X");
//
        Image img = imageRepository2.findById(id).get();

        String[] image = img.getDimensions().split("X");

        int len = Integer.valueOf(screen[0])/Integer.valueOf(image[0]);
        int br = Integer.valueOf(screen[1])/Integer.valueOf(image[1]);

        return len*br;

    }

}




















//package com.driver.services;
//
//import com.driver.models.*;
//import com.driver.repositories.*;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//
//@Service
//public class ImageService {
//
//    @Autowired
//    BlogRepository blogRepository2;
//    @Autowired
//    ImageRepository imageRepository2;
//
//    public Image addImage(Integer blogId, String description, String dimensions){
//        //add an image to the blog
//        Blog blog = blogRepository2.findById(blogId).get();
//        Image img = new Image(blog,description,dimensions);
//        blog.getImageList().add(img);
//        blogRepository2.save(blog);
//        return img;
//
//
//    }
//
//    public void deleteImage(Integer id){
//        imageRepository2.deleteById(id);
//
//    }
//
//    public int countImagesInScreen(Integer id, String screenDimensions) {
//        //Find the number of images of given dimensions that can fit in a screen having `screenDimensions`
//        String[] screen = screenDimensions.split("X");
//
//        Image img = imageRepository2.findById(id).get();
//
//        String[] image = img.getDimensions().split("X");
//
//        int len = Integer.valueOf(screen[0])/Integer.valueOf(image[0]);
//        int br = Integer.valueOf(screen[1])/Integer.valueOf(image[1]);
//
//        return len*br;
//
//    }
//}
