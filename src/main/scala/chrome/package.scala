import chrome.runtime.bindings.Runtime

import scala.util.{Try, Success, Failure}

import java.lang.Error

package object chrome {

  import scala.scalajs.js
  
  trait ChromeAPI {
    
    val name: String
    val requiredPermissions: List[String]
    
  }
  

  def lastErrorOrValue[T](value: => T): Try[T] = {
    Runtime.lastError.map{
      x => Failure(new Exception(x.message.getOrElse("")))
    }.getOrElse(Success(value))
  }

}
