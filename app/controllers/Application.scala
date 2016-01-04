package controllers

import models.BirthDate
import org.joda.time.DateTime
import play.api.mvc._

class Application extends Controller {
  def age(birthDate: BirthDate) = Action {
    Ok(DateTime.now().minusYears(birthDate.date.year().get()).getYear.toString)
  }
}