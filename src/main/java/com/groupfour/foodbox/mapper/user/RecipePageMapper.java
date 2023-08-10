package com.groupfour.foodbox.mapper.user;

import com.groupfour.foodbox.domain.BookmarkDTO;
import com.groupfour.foodbox.domain.ProductPageDTO;
import com.groupfour.foodbox.domain.RecipeDTO;
import com.groupfour.foodbox.domain.UserDTO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface RecipePageMapper {
    //사용자페이지 레시피 리스트
    List<RecipeDTO> recipeList(@Param("pageDTO") ProductPageDTO pageDTO);
    //레시피 총 개수
    int recipeCount();
    //레시피 정보가져오기
    RecipeDTO recipeView(Long id);
    //사용자가 레시피를 북마크했는지 체크
    BookmarkDTO bookmarkCheck(@Param("bookmarkDTO")BookmarkDTO bookmarkDTO);
    //북마크 등록
    int bookmarkRegister(@Param("bookmarkDTO") BookmarkDTO bookmarkDTO);
    //사용자 정보가져오기
    UserDTO userCheck(String user_id);
}
