import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class AulaSistemaTest {
	private String FALECONOSCO_URL = "https://portal.unicap.br/fale-conosco";
	private String GRADUACAO_URL = "https://portal.unicap.br/graduacao#presencial/";
	private WebDriver browser;
	private String UNICAP_URL = "https://portal.unicap.br/";
	private String GRADUACAO_ID = "layout_com_liferay_site_navigation_menu_web_portlet_SiteNavigationMenuPortlet_INSTANCE_third_navigation_menu_479161";
	private String FALE_CONOSCO_ID =  "layout_com_liferay_site_navigation_menu_web_portlet_SiteNavigationMenuPortlet_INSTANCE_first_navigation_menu_479081";
    private String NOME = "nomeFormFaleConosco";
    private String TELEFONE = "telefoneFormFaleConosco";
    private String ENVIAR = "sendFormFaleConosco";
    private String CHECK_ID = "_com_liferay_portal_search_web_site_facet_portlet_SiteFacetPortlet_term_1";
    private String BUSCA_ID = "wfkm___q";
    
   @BeforeEach
   public void beforeEach() {
	  System.setProperty("webdriver.chrome.driver","drivers/chromedriver.exe");
	   this.browser = new ChromeDriver();
		
   }
    
   @AfterEach
	public void afterEach() {
	   this.browser.close();
   }
  @Test
  public void redirecionamentoPaginaTest() throws Exception{
	this.browser.manage().window().maximize();
	this.browser.get(UNICAP_URL);
    WebElement botaoPaginaPrincipal = this.browser.findElement(By.id(GRADUACAO_ID));
    botaoPaginaPrincipal.click();
    Thread.sleep(3500);
    Assertions.assertEquals(GRADUACAO_URL, this.browser.getCurrentUrl());
  
  }

 
  @Test
  public void buscaFormularioTest() throws Exception{
	this.browser.manage().window().maximize();
	this.browser.get(UNICAP_URL);
    WebElement botaoPaginaPrincipal = this.browser.findElement(By.id(FALE_CONOSCO_ID));
    botaoPaginaPrincipal.click();
    Thread.sleep(3500);
    Assertions.assertEquals(FALECONOSCO_URL, this.browser.getCurrentUrl());
    this.browser.findElement(By.id(NOME)).sendKeys("Unicap");
    this.browser.findElement(By.id(TELEFONE)).sendKeys("00000000000");
    Thread.sleep(3500);
    
  }
  @Test
  public void mensagemErro() throws InterruptedException{
	  this.browser.manage().window().maximize();
		this.browser.get(UNICAP_URL);
	    WebElement botaoPaginaPrincipal = this.browser.findElement(By.id(FALE_CONOSCO_ID));
	    botaoPaginaPrincipal.click();
	    Thread.sleep(3500);
	    Assertions.assertEquals(FALECONOSCO_URL, this.browser.getCurrentUrl());
	    this.browser.findElement(By.id(NOME)).sendKeys("Unicap");
	    this.browser.findElement(By.id(TELEFONE)).sendKeys("00000000000");
	    Thread.sleep(3500);
	    this.browser.findElement(By.id("autorizo")).click();
	    this.browser.findElement(By.id(ENVIAR)).click();
	    Assertions.assertTrue(this.browser.getPageSource().contains("Digite um e-mail válido"));
    
  }

  @Test
  public void searchTest(){
	  this.browser.manage().window().maximize();
	  this.browser.get("https://www.globo.com/");
    Actions actions = new Actions(this.browser);

    WebElement search = this.browser.findElement(By.xpath("//*[@id=\"header-search-input\"]"));
    actions.moveToElement(search).click().perform();
    search.sendKeys("fantastico");
    search.submit();
    Assertions.assertEquals("https://www.globo.com/busca/?q=fantastico", this.browser.getCurrentUrl());

    WebElement busca = this.browser.findElement(By.xpath("//*[@id=\"q\"]"));
    Assertions.assertEquals("fantastico", busca.getAttribute("value"));
    

  }

  @Test
  public void tooltipTest(){
	  this.browser.manage().window().maximize();
	  this.browser.get("https://www.globo.com/");
    WebElement ge = this.browser.findElement(By.xpath("//*[@id=\"header-section\"]/div/div[4]/div[2]/a[4]"));
    Assertions.assertEquals("esporte", ge.getAttribute("title"));

  }
  
  @Test
  public void clickTest() throws Exception {
	  this.browser.manage().window().maximize();
	  this.browser.get(UNICAP_URL);
	  this.browser.findElement(By.id(BUSCA_ID)).sendKeys("Unicap");
	  this.browser.findElement(By.id(BUSCA_ID)).submit();
	  Thread.sleep(3000);
  }
  
  @Test
  public void checkBox() throws Exception {
	 this.browser.manage().window().maximize();
	  this.browser.get(UNICAP_URL);
	  this.browser.findElement(By.id(BUSCA_ID)).sendKeys("Unicap");
	  this.browser.findElement(By.id(BUSCA_ID)).submit();
	  Thread.sleep(3000);
	  this.browser.findElement(By.id(CHECK_ID)).click();
  }

}




