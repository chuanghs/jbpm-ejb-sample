package tw.idv.zmb.ejb;

import org.jbpm.services.ejb.api.UserTaskServiceEJBRemote;
import org.jbpm.services.ejb.client.ClientServiceFactory;
import org.jbpm.services.ejb.client.ServiceFactoryProvider;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by zombie on 2017/1/25.
 * java.naming.factory.initial=org.jnp.interfaces.NamingContextFactory
 java.naming.provider.url=jnp://localhost:1099
 java.naming.factory.url.pkgs=org.jboss.naming:org.jnp.interfaces
 jndi = "ejb:/sample-war-ejb-app.war/UserTaskServiceEJBImpl!org.jbpm.services.ejb.api.UserTaskServiceEJBRemote"
 */
public class Client {
    public static void main(String[] args) throws Exception {
        testSpringClient();
    }

    private static void testSpringClient() {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        UserTaskServiceEJBRemote userTaskService = (UserTaskServiceEJBRemote) context.getBean("userTaskService");
        System.out.println("====>" + userTaskService.getTask(123L));
    }

    private static void testJbpmEjbClient() throws javax.naming.NamingException {
        ClientServiceFactory factory = ServiceFactoryProvider.getProvider("JBoss");
        String application = "jbpm-ejb-service"; // use the app name, not the war name!!!
        System.out.println("=====> getting userTaskService");
        UserTaskServiceEJBRemote userTaskService = factory.getService(application, UserTaskServiceEJBRemote.class);
        System.out.println("====>" + userTaskService.getTask(123L));
    }
}
