package controllers

import play.api._
import play.api.mvc._

object Application extends Controller {
  import Logger._
  def index = Action { implicit request =>
    request.queryString.get("q").map(_.head) match {
      case Some(query) =>
        debug(query)
        Ok("name")
      case None =>
        Ok("please enter a query (append ?q=something to the URL)")
    }
  }

}