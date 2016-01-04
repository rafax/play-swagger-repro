Easy way to reproduce [this issue](https://github.com/swagger-api/swagger-play/issues/43)


Steps to reproduce:

* Clone this project and start Play with `sbt run`
* Navigate [here](http://localhost:9000/age?birthDate.year=1986&birthDate.month=11&birthDate.day=11)
* Observe that the request fails with

> CreationException: Unable to create injector, see the following errors:


> 1) Error injecting constructor, java.lang.IllegalArgumentException: Unrecognized Type: [null]
   at play.modules.swagger.SwaggerPluginImpl.<init>(SwaggerPlugin.scala:33)
   while locating play.modules.swagger.SwaggerPluginImpl
   at play.modules.swagger.SwaggerModule.bindings(SwaggerModule.scala:11):
 Binding(interface play.modules.swagger.SwaggerPlugin to ConstructionTarget(class play.modules.swagger.SwaggerPluginImpl) eagerly) (via modules: com.google.inject.util.Modules$OverrideModule -> play.api.inject.guice.GuiceableModuleConversions$$anon$1)
   while locating play.modules.swagger.SwaggerPlugin

> 1 error

App works fine if you remove the @Api annotation in app/controllers/Application.scala