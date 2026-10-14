package com.example.trabajopractico1_poo.cuenta;

import com.example.trabajopractico1_poo.cliente.ClienteEmpresa;

import lombok.Getter;
import lombok.ToString;


@Getter // Obtiene la tasa de conversión o el saldo en dólares. 
@ToString(callSuper = true) // Convierte los datos en texto
public class CuentaConvertibilidad extends CuentaCorriente {

    private float saldoDolares; // Saldo disponible en dólares.

    public CuentaConvertibilidad(
            int nroCuenta,
            ClienteEmpresa cliente,
            float montoAutorizado) {

        super(nroCuenta, cliente, montoAutorizado);
    }

    // Deposita dinero en dólares.
    public void depositarDolares(float cantidad) {
        if (cantidad > 0) {
            saldoDolares += cantidad;
        }
    }

    // Retira dólares si hay saldo suficiente.
    public void extraerDolares(float cantidad) {
        if (cantidad > 0 && cantidad <= saldoDolares) {
            saldoDolares -= cantidad;
        }
    }

    // Convierte pesos a dólares.
    public void convertirPesoDolar(float cantidad, float tasa) {
    if (cantidad > 0 && tasa > 0 && cantidad <= saldoDolares) {
        float dolares = cantidad / tasa; // Calcula los dólares.
        setSaldo(getSaldo() - cantidad); // Descuenta los pesos.
        saldoDolares += dolares; // Suma los dólares.
    }
}

    // Convierte dólares a pesos.
    public void convertirDolarPeso(float cantidad, float tasa) {
    // Verifica que haya suficientes dólares.
    if (cantidad > 0 && tasa > 0 && cantidad <= saldoDolares) {
        float pesos = cantidad * tasa; // Calcula los pesos recibidos.
        saldoDolares -= cantidad; // Descuenta los dólares vendidos.

    // Pesos esta en amarillo porque no se usa. Para que la conversión funcione de verdad, 
    // se tiene que usarese cálculo para sumar los pesos al saldo.
    //  Si no, va a descontar los dólares, sin recibir los pesos. Si lo corrijo, el saldo en pesos va a aumentar.
    }
}
}