import com.branegy.populito.*
import com.branegy.populito.formatter.*

Populito.DEBUG = false

Populito populito = new Populito(new ConsoleFormatter())
populito.loadConfiguration(new PopulitoConfig("config/User.cfg", "Users"))
populito.generateData(5)
