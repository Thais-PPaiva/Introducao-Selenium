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
	private WebDriver browser;
	
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
	  this.browser.get("https://portal.unicap.br/");
    WebElement botaoPaginaPrincipal = this.browser.findElement(By.id("layout_com_liferay_site_navigation_menu_web_portlet_SiteNavigationMenuPortlet_INSTANCE_third_navigation_menu_479161"));
    botaoPaginaPrincipal.click();
    Thread.sleep(3500);
    Assertions.assertEquals("https://portal.unicap.br/graduacao#presencial/", this.browser.getCurrentUrl());
  
  }

  @Test
  public void buscaFormularioTest(){
	  this.browser.manage().window().maximize();
    Actions actions = new Actions(this.browser);
    this.browser.get("https://www.globo.com/");
    WebElement buscaSection = this.browser.findElement(By.id("header-search-input"));
    actions.moveToElement(buscaSection).click().perform();
    Assertions.assertTrue(buscaSection.isEnabled());
    WebElement busca = this.browser.findElement(By.xpath("//*[@id=\"header-search-input\"]"));
    busca.sendKeys("fantastico");
    busca.submit();
    Assertions.assertTrue(this.browser.getCurrentUrl().contains("fantastico"));
    
  }
  @Test
  public void openFacebookPage(){
	  this.browser.get("https://fescfafic.edu.br/");
    WebElement facebookPageButton = this.browser.findElement(By.cssSelector("body > div.elementor.elementor-7318 > div > div > section.elementor-section.elementor-top-section.elementor-element.elementor-element-56443a69.elementor-section-boxed.elementor-section-height-default.elementor-section-height-default > div > div > div > div > div > div.elementor-element.elementor-element-35f1c4d5.elementor-shape-rounded.elementor-grid-0.e-grid-align-center.elementor-widget.elementor-widget-social-icons > div > div > div:nth-child(1) > a > i"));
    facebookPageButton.click();
    Assertions.assertEquals("https://www.facebook.com/FaculdadeFAFIC/", this.browser.getCurrentUrl());
    
  }

  @Test
  public void openInstagramPage(){
	  this.browser.get("https://fescfafic.edu.br/");
    WebElement facebookPageButton = this.browser.findElement(By.className("fa-instagram"));
    facebookPageButton.click();
    Assertions.assertEquals("https://www.instagram.com/faculdadefafic/?hl=pt-br", this.browser.getCurrentUrl());
   
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
    Actions actions = new Actions(this.browser);

    WebElement ge = this.browser.findElement(By.xpath("//*[@id=\"header-section\"]/div/div[4]/div[2]/a[4]"));
    actions.moveToElement(ge).perform();
    Assertions.assertEquals("esporte", ge.getAttribute("title"));

  }

}




