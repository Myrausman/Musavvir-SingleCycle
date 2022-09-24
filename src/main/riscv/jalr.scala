package riscv
import chisel3._
import chisel3.util._
class jalr extends Module {
    val io = IO(new Bundle {
        val pc4 = Input(SInt(3.W))
        val immd_se = Input(SInt(3.W))
	    val jalout = Output(SInt(5.W))
    })
    io.jalout:= (io.pc4 +io.immd_se) & 0xfffffffe.S
}
