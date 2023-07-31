package com.groupfour.foodbox.service;

import com.groupfour.foodbox.domain.CategoryDTO;
import com.groupfour.foodbox.domain.ProductDTO;
import com.groupfour.foodbox.mapper.ProductMapper;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.util.*;

@Service
public class ProductServiceImpl implements ProductService{
    @Autowired
    private ProductMapper productMapper;

    //상품 등록
    @SneakyThrows
    @Override
    public void adminProductRegister(MultipartHttpServletRequest mr, HttpServletRequest request) {
        //서버의 물리경로 얻어오기                                        //OS에 따라\\(윈도우) //
        String savePath = "C:\\foodbox\\src\\main\\resources\\static\\image";
        System.out.println(savePath);

        Map map = new HashMap();

        //mhr 텍스트 파일, 바이너리 파일의 정보를 모두 얻어올 수 있음
        Enumeration<String> enu = mr.getParameterNames();
        //일반 텍스트파일의 파라미터명(key), 해당 파라미터명의 value값을 가져옴
        while(enu.hasMoreElements()) {
            String paramName = enu.nextElement();
            String paramValue = mr.getParameter(paramName);
            System.out.println(paramName + " : "+ paramValue);
            map.put(paramName, paramValue);
        }
        //파일
        Iterator<String> iter = mr.getFileNames();

        List<String> fileList = new ArrayList<String>();

        while(iter.hasNext()) {

            String fileParamName = iter.next();
            System.out.println("fileParamName : "+ fileParamName);

            //MultipartFile : 파일정보를 갖고 있는 객체
            MultipartFile mFile = mr.getFile(fileParamName);
            String originName = mFile.getOriginalFilename();
            System.out.println("originName : " + originName);

            File file = new File(savePath+"\\"+fileParamName);
            if(mFile.getSize() != 0) {//업로드된 경우
                if(!file.exists()) {//파일이 존재하지 않으면
                    if(file.getParentFile().mkdir()) {
                        file.createNewFile();//임시파일 생성

                    }//if
                }//if
                File uploadFile = new File(savePath+"\\"+originName);
                //중복시 파일명 대체
                if(uploadFile.exists()) {
                    originName = System.currentTimeMillis()+" "+originName;
                    uploadFile = new File(savePath+"\\"+originName);
                }

                //실제 파일을 업로드하기
                mFile.transferTo(uploadFile);
                fileList.add(originName);
                map.put(fileParamName, originName);
            }//if
        }//while
        System.out.println("map = " + map);

        productMapper.adminProductRegister(map);
        for(Object objkey : map.keySet() ){
            String key = objkey.toString();
            System.out.println( String.format("키 -> %s, 값 -> %s", key, map.get(key)) );
            String keyValue = map.get(key).toString();
            if(key.contains("image_prod_image")){
                productMapper.adminProductImageRegister(keyValue);
            }
        }
    }
    //상품리스트
    @Override
    public List<ProductDTO> productList() {
        List<ProductDTO> productList = productMapper.productList();
        return productList;
    }
    //상품상세정보
    @Override
    public ProductDTO productInfo(int prod_code) {
        ProductDTO productDTO = productMapper.productInfo(prod_code);
        return productDTO;
    }
    //상품 상세이미지리스트
    @Override
    public List<String> productImageList(int prod_code) {
        List<String> productImageList = productMapper.productImageList(prod_code);
        return productImageList;
    }
}
