package net.idrok.shopping.service;

import net.idrok.shopping.entity.Fayl;

import java.util.List;


public interface FileService extends CommonService<Fayl>{
    List<Fayl> getAll(String key);
}
