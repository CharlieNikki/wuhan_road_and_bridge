import request from '@/utils/request'

// 查询项目检测信息列表
export function listDetectlist(query) {
  return request({
    url: '/detectlist/detectlist/list',
    method: 'get',
    params: query
  })
}

// 查询项目检测信息详细
export function getDetectlist(projectId) {
  return request({
    url: '/detectlist/detectlist/' + projectId,
    method: 'get'
  })
}

// 新增项目检测信息
export function addDetectlist(data) {
  return request({
    url: '/detectlist/detectlist',
    method: 'post',
    data: data
  })
}

// 修改项目检测信息
export function updateDetectlist(data) {
  return request({
    url: '/detectlist/detectlist',
    method: 'put',
    data: data
  })
}

// 删除项目检测信息
export function delDetectlist(projectId) {
  return request({
    url: '/detectlist/detectlist/' + projectId,
    method: 'delete'
  })
}

// 审批受理 by projectId
export function approvalDetect(projectId) {
  return request({
    url: '/detectlist/detectlist/' + projectId,
    method: 'put'
  })
}
