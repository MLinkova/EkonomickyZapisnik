/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EnitaaDao;


public enum PolozkaDaoFactory {
    INSTANCE;
    public MySqlPolozkaDao getMySqlPolozkaDao(){
     return  new MySqlPolozkaDao();
    }
}
