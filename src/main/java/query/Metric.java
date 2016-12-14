package query;

/**
 * Created by bilal on 12/15/16.
 */
public class Metric
{
    private String services;

    private String routes;

    private String metrics;

    private String __name__;

    private String value;

    private String job;

    private String instance;

    public String getServices ()
    {
        return services;
    }

    public void setServices (String services)
    {
        this.services = services;
    }

    public String getRoutes ()
    {
        return routes;
    }

    public void setRoutes (String routes)
    {
        this.routes = routes;
    }

    public String getMetrics ()
    {
        return metrics;
    }

    public void setMetrics (String metrics)
    {
        this.metrics = metrics;
    }

    public String get__name__ ()
    {
        return __name__;
    }

    public void set__name__ (String __name__)
    {
        this.__name__ = __name__;
    }

    public String getValue ()
    {
        return value;
    }

    public void setValue (String value)
    {
        this.value = value;
    }

    public String getJob ()
    {
        return job;
    }

    public void setJob (String job)
    {
        this.job = job;
    }

    public String getInstance ()
    {
        return instance;
    }

    public void setInstance (String instance)
    {
        this.instance = instance;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [services = "+services+", routes = "+routes+", metrics = "+metrics+", __name__ = "+__name__+", value = "+value+", job = "+job+", instance = "+instance+"]";
    }
}