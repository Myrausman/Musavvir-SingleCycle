package riscv
import chisel3._
import chisel3.util._
class data_Mem extends Module {
    val width : Int = 16
    val io = IO (new Bundle {
        val MemWrite  = Input ( Bool () )
        val MemRead =Input(Bool())
        val Data = Input(UInt(5.W)) 
        val Addr = Input ( UInt (32. W ) )
        val instRead = Output(UInt(32.W))
    })
    val mem=Mem(1024,UInt(32.W))
    when (io.MemWrite){
        mem.write(io.Addr,io.Data)

    }
    io.instRead:=mem.read(io.Addr)

}
