package riscv
import chisel3._
import chisel3.util._
class interface_ImmdValGen extends Bundle {
    val instr = Input ( UInt (32. W ) )
    val PC = Input (UInt(32.W))
    val immd_se = Output ( SInt (32. W ) )
}

import cntrl._
class ImmdValGen extends Module {
    val io = IO (new interface_ImmdValGen )
    val Op_code = io.instr(6,0)

// Start coding here
    io.immd_se := 0. S
    switch(Op_code){
        is( i_type){
            val out=Fill(20,io.instr(31))
            io.immd_se := (Cat(out, io.instr(31,20))).asSInt
        }
        is( s_type ){
            val out=Fill(20,io.instr(31))
            io.immd_se := (Cat(out,io.instr(31,25),io.instr(11,7))).asSInt
        }
        is(u_type){
            val out=Fill(12,io.instr(31))
            io.immd_se := (Cat(out,io.instr(31,12))).asSInt
        }
        is(sb_type){
            val out=Fill(19,io.instr(31))
            io.immd_se := (Cat(out,io.instr(31),io.instr(7),io.instr(30,25),io.instr(11,8))+io.PC).asSInt
        }
        is( jal ){
            val out=Fill(11,io.instr(31))
            io.immd_se := (Cat(out,io.instr(31),io.instr(19,12),io.instr(20),io.instr(30,21)) + io.PC).asSInt
        }
        is(load){
            val out=Fill(20,io.instr(31))
            io.immd_se := (Cat(out, io.instr(31,20))).asSInt
        }
    }
}