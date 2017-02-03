# jbpm-ejb-sample
JBPM EJB service sample
Sample project for using JBPM EJB service.


ejb-service is JBPM service project, need to deploy on jboss server.

ejb-client is sample code for using remote EJB to connect JBPM EJB service. Ths sample code only use userTaskService, 
other sample should refer to JBPM document.

You also need to create an application user using jboss add-user.sh script. The sample use ejbuser123 with ejbuser!23 as password.
