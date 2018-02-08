//package assignment1

//import scala.io.Source
//class q5 {

  def shoelace(str:String):Double= {

    val info = Source.fromFile(str, "UTF-8")

    val dataString = info.mkString.split("\\s+")
    val dataInt = dataString.map(_.toInt)

    val listAll = dataInt.toList
    val num = listAll.length

    val A = for(i<- 0 until num if(i%2==0)) yield listAll.drop(i).head //odd index case
    val B = for(k<- 0 until num if(k%2==1)) yield listAll.drop(k).head //even index case

    val x = A.toList
//    println("x is now "+x.toString()) //correct
    val y = B.toList
//    println("y is now "+y.toString())  //correct

    def helper(aa:List[Int],bb:List[Int]):Double={
        if(aa.length==1||bb.length==1){
          (aa.head * bb.head).toDouble
        }else {
          (aa.head * bb.head + helper(aa.drop(1), bb.drop(1))).toDouble
        }
    }

    val pA = helper(x,y.drop(1))

    val pB = (x.last * y.head).toDouble

    val pC = helper(x.drop(1),y)

    val pD = x.head * y.last.toDouble

//    println(pA+","+pB+","+pC+","+pD)


    ((pA+pB-pC-pD).abs)/2.0  //correct


  }
//}
