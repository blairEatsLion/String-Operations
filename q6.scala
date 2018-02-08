//package assignment1

//class q6 {

//return a function

  def stringPipeline(str:String): (String) => String={

    def helper(cur:String): ((String) => String)={
      cur.head match{
          case 'U' => (_:String).toUpperCase()
          case 'l' => (_:String).toLowerCase()
          case 'T' => (_:String).split(' ').map(_.capitalize).mkString(" ")
          case 'r' => (_:String).reverse
          case 's' => (_:String).sortWith(_<_)
          case '*' => (_:String).filter(!_.equals(' '))
        }
    }

    if(str.length==1){
      helper(str)
    } else{
      helper(str) andThen stringPipeline(str.tail)
    }

  }

//}
