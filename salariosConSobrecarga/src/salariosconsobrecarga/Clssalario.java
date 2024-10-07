//un metodo sobrecargado tres veces para hallar el salario neto
package salariosconsobrecarga;

public class Clssalario 
{
    
    private float sal_neto,sal_bruto;
    public float calcular_salario_neto
            (int nro_horas, float val_hora){
        float deducciones, aux_transporte=0;
        sal_bruto = nro_horas * val_hora;
        if(sal_bruto <= 4 * 1300000){
            deducciones = (sal_bruto * 8)/100;
            if(sal_bruto <= 2 * 1300000)
                aux_transporte = 162000;
        }else
            deducciones = (sal_bruto * 9)/100;
        sal_neto = sal_bruto - deducciones + aux_transporte;
        return sal_neto;
    }//Fin primera sobrecarga
    
    public float calcular_salario_neto
            (int nro_horas, float val_hora, float porc_descuento){
                sal_bruto=nro_horas * val_hora;
                sal_neto=sal_bruto * (1 - porc_descuento / 100);
                return sal_neto;
            }//fin segunda sobrecarga
                
    public float calcular_salario_neto
            (int nro_horas, float val_hora, double porc_descuento){
                sal_bruto=nro_horas * val_hora;
                sal_neto=sal_bruto * (1 - (float)porc_descuento / 100);
                return sal_neto;
            }//fin tercera sobrecarga
            
}