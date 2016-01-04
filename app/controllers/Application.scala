package controllers

import io.swagger.annotations.Api
import models.BirthDate
import org.joda.time.DateTime
import play.api.mvc._

@Api
class Application extends Controller {
  def age(birthDate: BirthDate) = Action {
    Ok(DateTime.now().minusYears(birthDate.date.year().get()).getYear.toString)
  }
}