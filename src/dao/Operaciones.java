/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package dao;

import java.util.List;
import java.util.Map;

/**
 *
 * @author admin
 */
public interface Operaciones<T> {
    int create (T t);
    int update (T t);
    int delete (int id);
    T read(int id);
    List<T> readAll();
    List<Map<String,Object>> readAll2(int id);
}
