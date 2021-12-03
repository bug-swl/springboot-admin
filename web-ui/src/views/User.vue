<template>
  <div class="user">
    <div style="text-align: left;margin-bottom: 10px">
      <el-button type="primary" @click="addShow">新增</el-button>
      <el-button type="primary">导入</el-button>
      <el-button type="primary">导出</el-button>
    </div>
    <div>
      <el-table
        v-loading="loading"
        :data="filterTableData"
        :border="hasBorder"
        :stripe="hasStripe"
        style="width: 100%"
      >
        <el-table-column sortable label="ID" prop="id"/>
        <el-table-column label="用户名" prop="username">
          <template #default="scope">
            <!--            <el-popover effect="light" trigger="hover" placement="top">-->
            <!--              <template #default>-->
            <!--                <p>姓名: {{ scope.row.name }}</p>-->
            <!--                <p>住址: {{ scope.row.address }}</p>-->
            <!--              </template>-->
            <!--              <template #reference>-->
            <div class="name-wrapper">
              <el-tag size="medium">{{ scope.row.username }}</el-tag>
            </div>
            <!--              </template>-->
            <!--            </el-popover>-->
          </template>
        </el-table-column>
        <el-table-column label="昵称" prop="nickName"/>
        <el-table-column label="年龄" prop="age"/>
        <el-table-column label="性别" prop="sex"/>
        <el-table-column label="地址" prop="address"/>
        <el-table-column align="right">
          <template #header>
            <el-input v-model="search" size="mini" placeholder="Type to search"/>
          </template>
          <template #default="scope">
            <el-button size="mini" @click="handleEdit(scope.$index, scope.row)">
              Edit
            </el-button>
            <el-popconfirm
              confirm-button-text="OK"
              cancel-button-text="No, Thanks"
              icon="el-icon-info"
              icon-color="red"
              title="Are you sure to delete this?"
              @confirm="confirmEvent(scope.$index,scope.row)"
              @cancel="cancelEvent"
            >
              <template #reference>
                <el-button size="mini"
                           type="danger">
                  Delete
                </el-button>
              </template>
            </el-popconfirm>
          </template>
        </el-table-column>
      </el-table>
      <div style="margin-top:10px ">
        <el-pagination
          v-model:currentPage="pagination.current"
          :page-sizes="[5, 10, 20, 40]"
          v-model:page-size="pagination.size"
          layout="total, sizes, prev, pager, next, jumper"
          :total="pagination.total"
          @size-change="handleSizeChange"
          @current-change="handleCurrentChange"
        >
        </el-pagination>
      </div>
    </div>
    <el-dialog
      title="用户信息"
      v-model="dialogVisible"
      width="600px"
    >
      <el-form :model="form" style="text-align: left;width: 80%">
        <el-form-item label="用户名" :label-width="formLabelWidth">
          <el-input placeholder="用户名" v-model="form.username" autocomplete="off"></el-input>
        </el-form-item>
        <el-form-item label="昵称" :label-width="formLabelWidth">
          <el-input placeholder="昵称" v-model="form.nickName" autocomplete="off"></el-input>
        </el-form-item>
        <el-form-item label="年龄" :label-width="formLabelWidth">
          <el-input placeholder="年龄" v-model="form.age" autocomplete="off"></el-input>
        </el-form-item>
        <el-form-item label="性别" placeholder="性别" :label-width="formLabelWidth">
          <el-radio-group v-model="form.sex">
            <el-radio label="1">男</el-radio>
            <el-radio label="2">女</el-radio>
          </el-radio-group>
        </el-form-item>
        <el-form-item label="地址" :label-width="formLabelWidth">
          <el-input placeholder="地址" v-model="form.address" autocomplete="off"></el-input>
        </el-form-item>
      </el-form>
      <div slot="footer" class="dialog-footer" style="text-align: right">
        <el-button @click="dialogVisible = false">取 消</el-button>
        <el-button type="primary" @click="save">确 定</el-button>
      </div>
    </el-dialog>
  </div>
</template>

<script>
// @ is an alias to /src

import MyBar from '@/components/MyBar'
import request from '@/utils/request'
import appConsole from '@/utils/console'
import { ElMessage } from 'element-plus'

export default {
  name: 'Home',
  components: { MyBar },
  data () {
    return {
      loading: true,
      dialogVisible: false,
      total: 10,
      hasBorder: true,
      hasStripe: true,
      search: '',
      pagination: {
        countId: '',
        current: 1,
        maxLimit: '',
        optimizeCountSql: true,
        orders: '',
        pages: 0,
        records: [],
        searchCount: true,
        size: 10,
        total: 0,
      },
      tableData: [],
      form: {
        id: null,
        username: '',
        password: '',
        age: '',
        nickName: '',
        sex: '1',
        address: '',
      },
      formLabelWidth: '120px'
    }
  },
  computed: {
    filterTableData: {
      get () {
        return this.pagination.records.filter(
          data => {
            return !this.search
              || data.username.toLowerCase().includes(this.search.toLowerCase())
          }
        )
      }
    }
  },

  methods: {
    handleEdit (index, row) {
      appConsole.log(row)
      this.form = JSON.parse(JSON.stringify(row))
      this.dialogVisible = true

    },
    addShow () {
      this.dialogVisible = true
      this.form = {
        username: '',
        password: '',
        age: '',
        nickName: '',
        sex: '1',
        address: '',
      }
    },
    save () {
      let type = 'success'
        , message = ''
      if (this.form.id) {
        request.put(
          '/user',
          this.form
        ).then(res => {
          appConsole.log(res)
          if (res.code === '200') {
            this.load()
            this.dialogVisible = false
          }
          if (res.code !== '200') {
            type = 'error'
          }
          message = res.msg
          ElMessage({
            message,
            type
          })
        })
      } else {
        request.post('/user',
          this.form
        ).then(res => {
          appConsole.log(res)
          if (res.code === '200') {
            this.load()
            this.dialogVisible = false
          }
          if (res.code !== '200') {
            type = 'error'
          }
          message = res.msg
          ElMessage({
            message,
            type
          })
        })
      }
    },
    load () {
      this.loading = true
      request.get(
        '/user',
        {
          params: {
            pageSize: this.pagination.size,
            currentPage: this.pagination.current,
            search: this.search
          }
        }).then(res => {
        this.pagination = res.data
      }).finally(() => {
        this.loading = false
      })
    },

    confirmEvent (index, row) {
      appConsole.log(row)
      request.delete(
        '/user',
        {
          params: { id: row.id }
        }).then(res => {
        appConsole.log(res)
        if (res.code === '200') {
          this.load()
          ElMessage({
            message:"删除成功",
            type:'success'
          })
        }
      })
    },
    cancelEvent () {
    },
    handleSizeChange () {
      this.load()
    },
    handleCurrentChange () {
      this.load()
    }

  },
  created () {
    this.load()
  }
}
</script>
<style lang="scss">

</style>
