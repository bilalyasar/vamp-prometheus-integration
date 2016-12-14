package query;

/**
 * Created by bilal on 12/15/16.
 */
public class Result
{
    private Metric metric;

    private String[] value;

    public Metric getMetric ()
    {
        return metric;
    }

    public void setMetric (Metric metric)
    {
        this.metric = metric;
    }

    public String[] getValue ()
    {
        return value;
    }

    public void setValue (String[] value)
    {
        this.value = value;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [metric = "+metric+", value = "+value+"]";
    }
}

