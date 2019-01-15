package com.lookingforstar.server.dao.mybatis.mapper;

import com.lookingforstar.server.model.GooglePhotoItem;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface PhotoMapper {
    @Insert("INSERT INTO btsPhoto(url) SELECT (?) FROM DUAL WHERE NOT EXISTS (SELECT * FROM btsPhoto WHERE url=(?))")
    int insertBtsPhoto();

    @Select("select * from btsPhoto")
    List<GooglePhotoItem> getBtsPhoto();

}
