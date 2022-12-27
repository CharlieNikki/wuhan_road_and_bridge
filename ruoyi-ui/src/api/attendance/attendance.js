import request from '@/utils/request'

// 查询外检考勤列表
export function listAttendance(query) {
  return request({
    url: '/attendance/attendance/list',
    method: 'get',
    params: query
  })
}

// 查询外检考勤详细
export function getAttendance(id) {
  return request({
    url: '/attendance/attendance/' + id,
    method: 'get'
  })
}

// 新增外检考勤
export function addAttendance(data) {
  return request({
    url: '/attendance/attendance',
    method: 'post',
    data: data
  })
}

// 修改外检考勤
export function updateAttendance(data) {
  return request({
    url: '/attendance/attendance',
    method: 'put',
    data: data
  })
}

// 删除外检考勤
export function delAttendance(id) {
  return request({
    url: '/attendance/attendance/' + id,
    method: 'delete'
  })
}
