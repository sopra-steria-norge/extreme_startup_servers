package controllers

import play.api._
import play.api.mvc._

object Application extends Controller {
  import Logger._
  def index = Action { implicit request =>
    val q=request.queryString("q")(0)
    debug(q)
    Ok("name")
  }

}