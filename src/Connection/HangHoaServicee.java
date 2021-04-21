/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Connection;

import java.util.List;

/**
 *
 * @author ADMIN
 */
public class HangHoaServicee {
    private HangHoaDao hangHoaDao;

    public HangHoaServicee() {
        hangHoaDao = new HangHoaDao();
    }
    public List<HangHoa> getAllHang(){
        return hangHoaDao.getAllHang();
    }
    
    public void addHang(HangHoa hanghoa){
        hangHoaDao.addHang(hanghoa);
    }
    public void deleteHang(String mahang){
        hangHoaDao.deleteHang(mahang);
    }
    public void updateHang(HangHoa hanghoa){
        hangHoaDao.updateHang(hanghoa);
    }
    public HangHoa getHangByMa(String mahang){
        return hangHoaDao.getHangByMa(mahang);
    }
}
