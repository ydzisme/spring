<template>
  <el-container style="height: 100vh;">
    <el-main>
      <div>
        <div style="margin: 10px 5px">
          <el-button type="primary" @click="dialogVisible = true">新增</el-button>
          <el-button type="primary">其它</el-button>
        </div>
        <div>
          <el-input v-model="search" style="width: 30%;" placeholder="请输入关键字"/>
          <el-button style="margin-left: 10px" type="primary">搜索</el-button>
        </div>
        <el-table :data="tableData" stripe style="width: 100%">
          <el-table-column sortable prop="date" label="日期"/>
          <el-table-column prop="name" label="商品名"/>
          <el-table-column prop="address" label="生产商"/>
          <el-table-column fixed="right" label="操作" min-width="120">
            <template #default="scope">
              <el-button link type="primary" size="small" @click="handleEdit()">
                删除
              </el-button>
              <el-button link type="primary" size="small">编辑</el-button>
            </template>
          </el-table-column>
        </el-table>
      </div>
    </el-main>
  </el-container>
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
      form: {},
      tableData: [
        {
          date: '2016-05-03',
          name: 'Tom',
          address: 'No. 189, Grove St, Los Angeles',
        },
        {
          date: '2016-05-02',
          name: 'Tom',
          address: 'No. 189, Grove St, Los Angeles',
        },
        {
          date: '2016-05-04',
          name: 'Tom',
          address: 'No. 189, Grove St, Los Angeles',
        },
        {
          date: '2016-05-01',
          name: 'Tom',
          address: 'No. 189, Grove St, Los Angeles',
        },
      ]
    }
  },
  methods: {
    add() {
      this.dialogVisible = true
      this.form = {}
    },
    save() {
      request.post("api/ssm/save",this.form).then(res =>{
        console.log("res",res)
        this.dialogVisible = false
      })
    }
  }

}
</script>
