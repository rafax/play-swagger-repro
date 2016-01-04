package models

import org.joda.time.DateTime
import play.api.mvc.QueryStringBindable


case class BirthDate(year: Int, month: Int, day: Int) {
  val date = new DateTime(year, month, day, 0, 0)
}


object BirthDateBinder {
  implicit def queryStringBinder(implicit intBinder: QueryStringBindable[Int]) = new QueryStringBindable[BirthDate] {
    override def bind(key: String, params: Map[String, Seq[String]]): Option[Either[String, BirthDate]] = {
      for {
        year <- intBinder.bind(key + ".year", params)
        month <- intBinder.bind(key + ".month", params)
        day <- intBinder.bind(key + ".day", params)
      } yield {
        (year, month, day) match {
          case (Right(year), Right(month), Right(day)) => Right(BirthDate(year, month, day))
          case _ => Left(s"Unable to bind BirthDate for $key")
        }
      }
    }

    override def unbind(key: String, bdate: BirthDate): String = {
      intBinder.unbind(key + ".year", bdate.year) + "&" + intBinder.unbind(key + ".month", bdate.month) + "&" + intBinder.unbind(key + ".day", bdate.day)
    }
  }
}
