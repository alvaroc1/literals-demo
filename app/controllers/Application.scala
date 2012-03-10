package controllers

import play.api._
import play.api.mvc._
import play.api.templates.Html
import scala.xml.Xhtml

object Application extends Controller {
  
  def index = Action {
    
    case class Task(user: String, content: String)
    
    val tasks = Seq(
      Task("Alvaro", "Make simple site"), 
      Task("Someone else", "Make it awesome"),
      Task("Jim", "Make it crazy fast")
    )
    
    Ok(
      Html(
        "<!DOCTYPE html>" + 
        xml.Xhtml.toXhtml(
          <html>
          <head>
            <title>Some Awesome Site</title>
            <link rel="stylesheet" media="screen" href="/assets/stylesheets/main.css"/>
            <link rel="shortcut icon" type="image/png" href="/assets/images/favicon.png"/>
            <script src="/public/javascripts/jquery-1.7.1.min.js" type="text/javascript"></script>
          </head>
          <body>
            <div id='header'>
              <h1>Some  Awesome Site</h1>
            </div>
            <div id='page'>
              
              <div class='panel'>
                <h2>Tasks</h2>
  
                {for (task <- tasks) yield
                  <div>
                    {task.user} - {task.content}
                  </div>
                }
              </div>
              
              <div class='panel'>
                <h2>Find Patch</h2>
  
                <form>
                  <label>Zip Code: </label><br/>
                  <input type='text' name='zip' />
                  <button>Find</button>
                </form>
              </div>

            </div>
            <div id='footer'>
              Boo!
            </div>
          </body>
          </html>
        )
      )
    ) 
  }
  
  
  def site (content: Seq[xml.Node]) = Html {
    "<!DOCTYPE html>" + 
    xml.Xhtml.toXhtml(
      <html>
        <head>
          <title>Some Awesome Site</title>
          <link rel="stylesheet" media="screen" href="/assets/stylesheets/main.css"/>
          <link rel="shortcut icon" type="image/png" href="/assets/images/favicon.png"/>
          <script src="/public/javascripts/jquery-1.7.1.min.js" type="text/javascript"></script>
        </head>
        <body>
          {content}
        </body>
      </html>
    )
  }
  
  def page (content: Seq[xml.Node]) = site {
    <div id='wrapper'>
      <div id='header'>
        <h1>Some  Awesome Site</h1>
      </div>
      <div id='page'>
        {content}        
      </div>
    </div>
  }
  
}
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  /*
  def index = Action {
    
    case class Task(user: String, content: String)
    
    val tasks = List(
      Task("Alvaro", "Make simple site"), 
      Task("Someone else", "Make it awesome"),
      Task("Jim", "Make it crazy fast")
    )
    
    Ok(
      page {       
        <h2>Tasks</h2>

        <div class='tasks'>
        {for (task <- tasks) yield
          <div>
            {task.user} - {task.content}
          </div>
        }
        </div>
        
        <h2>Find Patch</h2>

        <form>
          <label>Zip Code: </label><br/>
          <input type='text' name='zip' />
          <button>Find</button>
        </form>
      }
    ) 
  }
  
  def site (content: Seq[xml.Node]) = Html {
    "<!DOCTYPE html>" + 
    xml.Xhtml.toXhtml(
      <html>
        <head>
          <title>Some Awesome Site</title>
          <link rel="stylesheet" media="screen" href="/assets/stylesheets/main.css"/>
          <link rel="shortcut icon" type="image/png" href="/assets/images/favicon.png"/>
          <script src="/public/javascripts/jquery-1.7.1.min.js" type="text/javascript"></script>
        </head>
        <body>
          {content}
        </body>
      </html>
    )
  }
  
  def page (content: Seq[xml.Node]) = site {
    <div id='wrapper'>
      <div id='header'>
        <h1>Some  Awesome Site</h1>
      </div>
      <div id='page'>
        {content}        
      </div>
    </div>
  }
  
  def panel (title: String)(content: Seq[xml.Node]) = {
    <div class='panel'>
      <h2>{title}</h2>

      {content}
    </div>
  }
  */
