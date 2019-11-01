package dao;

import java.util.List;

import entity.Goods;

public interface IDao<T> {
	void insert(T g);
	Goods selectById(int id);
	List<T> selectAll();
    void updateById(T newT);
    void deleteById(int tId);
    boolean isExist(int tId);
    
//    void insertGoods(Goods g);
//	Goods selectGoodsById(int goodId);
//	List<Goods> selectGoodsAll();
//    void updateGoods(Goods newGoods);
//    void deleteGoodsById(int goodId);
//    boolean isExist(int goodId);
}
