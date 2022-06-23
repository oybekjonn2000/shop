package net.idrok.shopping.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface CommonService<T> {
    
        /**
     * bu metod bazadan barcha entity~larni o'qib olishga mo'ljallangan
     * 
     * @param pageable
     * @param s
         * @return key
     */
    public Page<T> getAll(Pageable pageable, String key);

    /**
     * bu metod bazadan barcha entity~larni Id orqali o'qib olishga mo'ljallangan
     * 
     * @param id
     * @return
     */
    public T getById(Long id);

    /**
     * bu metod bazaga yangi entity qo'shish uchun
     * 
     * @param entity
     * @return yngi qoshilgan entity qaytadi
     */
    public T create(T entity);

    /**
     * bu metod entity o'zgartirish uchun
     * 
     * @param entity
     * @return o'zgartrilgan entity qaytadi
     */
    public T update(T entity);

    /**
     * bu metod brandni uchirish uchun
     * 
     * @param entity
     */
    public void delete(T entity);

    /**
     * bu metod entity~ni Id orqali uchirish uchun
     * 
     * @param entityId 
     */
    public void deleteById(Long entityId);
}
