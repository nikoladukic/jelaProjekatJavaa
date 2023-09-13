/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package transfer.util;

/**
 *
 * @author Ана
 */
public interface Operation {

    public static final int LOGIN = 0;

    public static final int ADD_JELO = 1;
    public static final int DELETE_JELO = 2;
    public static final int UPDATE_JELO = 3;
    public static final int GET_ALL_JELO = 4;

    public static final int ADD_NARUDZBINA = 5;
    public static final int DELETE_NARUDZBINA = 6;
    public static final int UPDATE_NARUDZBINA = 7;
    public static final int GET_ALL_NARUDZBINA = 8;

    public static final int GET_ALL_STAVKA_NARUDZBINE = 9;

    public static final int GET_ALL_KURIR = 10;

    public static final int GET_ALL_KLIJENT = 11;

}
