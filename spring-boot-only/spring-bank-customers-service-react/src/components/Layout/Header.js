import React, { Component } from "react";
import { Dropdown, Icon, Menu, Segment } from 'semantic-ui-react'
import { Link } from 'react-router-dom'

class Header extends Component {
  state = {}
  
  handleItemClick = (e, { name }) => this.setState({ activeItem: name })

  render() {
    const { activeItem } = this.state
    return (
      <div>
      
      <div>
      <Menu attached='top'>
        <Menu.Item
          name='editorials'
          active={activeItem === 'editorials'}
          onClick={this.handleItemClick}
          as={Link} to='/dashboard'
        >
          Dashboard
        </Menu.Item>
        <Dropdown item icon='wrench' simple>
          <Dropdown.Menu>
            <Dropdown.Item>
              <Icon name='dropdown' />
              <span className='text'>New</span>
  
              <Dropdown.Menu>
                <Dropdown.Item>Document</Dropdown.Item>
                <Dropdown.Item>Image</Dropdown.Item>
              </Dropdown.Menu>
            </Dropdown.Item>
            <Dropdown.Item>Open</Dropdown.Item>
            <Dropdown.Item>Save...</Dropdown.Item>
            <Dropdown.Item>Edit Permissions</Dropdown.Item>
            <Dropdown.Divider />
            <Dropdown.Header>Export</Dropdown.Header>
            <Dropdown.Item>Share</Dropdown.Item>
          </Dropdown.Menu>
        </Dropdown>
  
        
        <Menu.Menu position="right">
        <div className='ui right aligned category search item'>
            <div className='ui transparent icon input'>
              <input
                className='prompt'
                type='text'
                placeholder='Search animals...'
              />
              <i className='search link icon' />
            </div>
            <div className='results' />
            
          </div>
          <Menu.Item
            name='editorials'
            active={activeItem === 'editorials'}
            onClick={this.handleItemClick}
            as={Link} to='/addUser'
          >
            Sign Up
          </Menu.Item>
          <Menu.Item
            name='editorials'
            active={activeItem === 'editorials'}
            onClick={this.handleItemClick}
            as={Link} to='/addUser'
          >
            Login
          </Menu.Item>
        </Menu.Menu>
      </Menu>
  
    </div>
    </div>
    );
  }
}

export default Header;
