import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.theladders.solid.isp.oldjob.JobImpl;
import com.theladders.solid.isp.oldjob.JobInfoComposite;


public class TestJobInfoComposite
{
  
  private JobInfoComposite composite;
  
  private void givenAJobInfoCompositeInstance()
  {
    composite = new JobInfoComposite();
  }

  private void whenISetTheDefaultValuesOnTheJobInfoComposite()
  {
    composite.setCompany("Example Ltd.");
  }

  @Before
  public void setUp()
  {
    givenAJobInfoCompositeInstance();
    whenISetTheDefaultValuesOnTheJobInfoComposite();
  }

  @Test
  public void thenItShouldHaveTheRightCompanyName()
  {
    assertEquals("Example Ltd.", composite.getCompany());
  }

}
