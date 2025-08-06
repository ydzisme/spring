<template>
  <el-container style="height: 100vh;">
    <el-main>
      <div>
        <div style="margin: 10px 5px">
          <el-button type="primary" @click="add">新增</el-button>
          <el-button type="primary">其它</el-button>
        </div>
        <div>
          <el-input v-model="search" style="width: 30%;" placeholder="请输入关键字"/>
          <el-button style="margin-left: 10px" type="primary">搜索</el-button>
        </div>
        <el-table :data="tableData" stripe style="width: 100%">
          <el-table-column sortable prop="id" label="ID"/>
          <el-table-column prop="name" label="商品名"/>
          <el-table-column prop="maker" label="生产商"/>
          <el-table-column prop="price" label="价格"/>
          <el-table-column prop="sales" label="销量"/>
          <el-table-column prop="stock" label="库存"/>
          <el-table-column fixed="right" label="操作" min-width="120">
            <template #default="scope">
              <el-button link type="primary" size="small" @click="handleDelete(scope.row.id)">
                删除
              </el-button>
              <el-button link type="primary" size="small" @click="handleEdit(scope.row)">编辑</el-button>
            </template>
          </el-table-column>
        </el-table>
      </div>
    </el-main>
  </el-container>
<!--  添加-->
  <el-dialog title="添加新家具" v-model="dialogVisible" width="30%">
    <el-form :model="form" label-width="120px">
      <el-form-item label="家居名">
        <el-input v-model="form.name" style="width: 80%"></el-input>
      </el-form-item>
      <el-form-item label="厂商">
        <el-input v-model="form.maker" style="width: 80%"></el-input>
      </el-form-item>
      <el-form-item label="价格">
        <el-input v-model="form.price" style="width: 80%"></el-input>
      </el-form-item>
      <el-form-item label="销量">
        <el-input v-model="form.sales" style="width: 80%"></el-input>
      </el-form-item>
      <el-form-item label="库存">
        <el-input v-model="form.stock" style="width: 80%"></el-input>
      </el-form-item>
    </el-form>
    <template #footer>
    <span class="dialog-footer">
      <el-button @click="dialogVisible = false">取 消</el-button>
      <el-button type="primary" @click="save">确 定</el-button>
    </span>
    </template>
  </el-dialog>
<!--  修改-->
  <el-dialog title="修改家具信息" v-model="dialogVisible1" width="30%">
    <el-form :model="form" label-width="120px">
      <el-form-item label="家居名">
        <el-input v-model="form.name" style="width: 80%"></el-input>
      </el-form-item>
      <el-form-item label="厂商">
        <el-input v-model="form.maker" style="width: 80%"></el-input>
      </el-form-item>
      <el-form-item label="价格">
        <el-input v-model="form.price" style="width: 80%"></el-input>
      </el-form-item>
      <el-form-item label="销量">
        <el-input v-model="form.sales" style="width: 80%"></el-input>
      </el-form-item>
      <el-form-item label="库存">
        <el-input v-model="form.stock" style="width: 80%"></el-input>
      </el-form-item>
    </el-form>
    <template #footer>
    <span class="dialog-footer">
      <el-button @click="dialogVisible1 = false">取 消</el-button>
      <el-button type="primary" @click="update">确 定</el-button>
    </span>
    </template>
  </el-dialog>
</template>

<script>
import request from "@/util/request";
export default {
  name: 'HomeView',
  components: {},
  data() {
    return {
      search: '',
      dialogVisible: false,
      dialogVisible1: false,
      form: {},
      tableData: []
    }
  },
  created() {
    this.findAll()
  },
  methods: {
    add() {
      this.dialogVisible = true
      this.form = {}
    },
    // 存储
    save() {
      request.post("api/ssm/save",this.form).then(res =>{
        console.log("res",res)
        this.dialogVisible = false
        this.findAll()
      })
    },
    // 更新
    update() {
      request.post("api/ssm/update",this.form).then(res => {
        console.log("res",res)
        this.dialogVisible1 = false
        this.findAll()
        // 更新完成消息弹窗
        if(res.code === 200){
          this.$message(
              {
                type:"success",
                message:"更新成功!"
              }
          )
        }else{
          this.$message(
              {
                type:"error",
                message:"更新失败！"
              }
          )
        }
      })
    },
    // 查询全部信息
    findAll() {
      request.get(("api/ssm/findAll")).then(res => {
        console.log("res",res)
        this.tableData = res.extend.furns
      })
    },
    handleEdit(row){
      this.form = JSON.parse(JSON.stringify(row));

      this.dialogVisible1 = true
    },
    handleDelete(id){
      const requestData = { id: Number(id) };
      request.post("api/ssm/delete",requestData).then(res => {
        console.log("res",res)
      })
      this.findAll()
    }
  }
}
</script>
