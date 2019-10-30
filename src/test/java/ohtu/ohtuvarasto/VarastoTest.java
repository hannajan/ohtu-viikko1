package ohtu.ohtuvarasto;

import org.junit.*;
import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class VarastoTest {

    Varasto varasto;
    Varasto varasto2;
    double vertailuTarkkuus = 0.0001;

    @Before
    public void setUp() {
        varasto = new Varasto(10);
    }

    @Test
    public void konstruktoriLuoTyhjanVaraston() {
        assertEquals(0, varasto.getSaldo(), vertailuTarkkuus);
    }

    @Test
    public void uudellaVarastollaOikeaTilavuus() {
        assertEquals(10, varasto.getTilavuus(), vertailuTarkkuus);
    }

    @Test
    public void lisaysLisaaSaldoa() {
        varasto.lisaaVarastoon(8);

        // saldon pitäisi olla sama kun lisätty määrä
        assertEquals(8, varasto.getSaldo(), vertailuTarkkuus);
    }

    @Test
    public void lisaysLisaaPienentaaVapaataTilaa() {
        varasto.lisaaVarastoon(8);

        // vapaata tilaa pitäisi vielä olla tilavuus-lisättävä määrä eli 2
        assertEquals(2, varasto.paljonkoMahtuu(), vertailuTarkkuus);
    }

    @Test
    public void ottaminenPalauttaaOikeanMaaran() {
        varasto.lisaaVarastoon(8);

        double saatuMaara = varasto.otaVarastosta(2);

        assertEquals(2, saatuMaara, vertailuTarkkuus);
    }

    @Test
    public void ottaminenLisääTilaa() {
        varasto.lisaaVarastoon(8);

        varasto.otaVarastosta(2);

        // varastossa pitäisi olla tilaa 10 - 8 + 2 eli 4
        assertEquals(4, varasto.paljonkoMahtuu(), vertailuTarkkuus);
    }
    
    @Test
    public void konstruktoriLuoVarastonAnnetullaAlkusaldolla() {
        Varasto var = new Varasto(10, 8);
        
        assertEquals(8, var.getSaldo(), vertailuTarkkuus);
    }
    
    @Test
    public void konstruktoriEiLuoNegatiivisellaAlkusaldollaVarastoa() {
        Varasto var = new Varasto(10, -4);
        
        assertEquals(0, var.getSaldo(), vertailuTarkkuus);
    }
    
    @Test
    public void konstruktoriEiLuoSaldoaJokaYliTilavuuden() {
        Varasto var = new Varasto(10, 20);
        
        assertEquals(10, var.getSaldo(), vertailuTarkkuus);
    }

    @Test
    public void konstruktoriEiLuoVarastoaNegatiivisellaTilavuudella() {
        Varasto var = new Varasto(-1);
        
        assertEquals(0, var.getTilavuus(), vertailuTarkkuus);
    }
    
    @Test
    public void toinenKonstruktoriEiLuoVarastoaNegatiivisellaTilavuudella() {
        Varasto var = new Varasto(-1, 5);
        
        assertEquals(0, var.getTilavuus(), vertailuTarkkuus);
    }
    
    @Test
    public void lisaaVarastoonEiHyvaksyNegatiivistaMaaraa() {
        varasto.lisaaVarastoon(-1);
        
        assertEquals(0, varasto.getSaldo(), vertailuTarkkuus);
    }
    
    @Test
    public void lisaaVarastoonEiLisaaYliTilavuuden() {
        varasto.lisaaVarastoon(20);
        
        assertEquals(10, varasto.getSaldo(), vertailuTarkkuus);
    }
    
    @Test
    public void otaVarastostaEiHyvaksyNegatiivistaMaaraa() {
        Varasto var = new Varasto(10, 5);
        
        assertEquals(0.0, var.otaVarastosta(-5), vertailuTarkkuus);
    }
    
    @Test
    public void negatiivinenOttaminenEiMuutaSaldoa() {
        Varasto var = new Varasto(10, 5);
        var.otaVarastosta(-5);
        
        assertEquals(5, var.getSaldo(), vertailuTarkkuus);
    }
    
    @Test
    public void ottaminenEiAnnaEnempaaKuinSaldo() {
        Varasto var = new Varasto(10, 5);
        
        assertEquals(5, var.otaVarastosta(8), vertailuTarkkuus);
    }
    
    @Test
    public void saldoOnNollaKunOtetaanNiinPaljonKuinVoi() {
        Varasto var = new Varasto(10, 5);
        var.otaVarastosta(8);
        
        assertEquals(0, var.getSaldo(), vertailuTarkkuus);
    }
    
    @Test
    public void tulosteOikein() {
        Varasto var = new Varasto(10, 5);
        
        assertEquals("saldo = 5.0, vielä tilaa 5.0", var.toString());
    }
}