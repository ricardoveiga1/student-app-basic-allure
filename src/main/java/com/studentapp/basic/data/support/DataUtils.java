package com.studentapp.basic.data.support;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DataUtils {

    public static String getDataDiferencaDias(Integer qtdDias) {
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DAY_OF_MONTH, qtdDias);
        return getDataFormatada(cal.getTime());
    }

    public static String getDataFormatada(Date data) {
        DateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        return format.format(data);
    }
}


 //mov.setData_transacao(DataUtils.getDataDiferencaDias(-1)); //ontem
   //      mov.setData_pagamento(DataUtils.getDataDiferencaDias(5)); // 5 dias a frente