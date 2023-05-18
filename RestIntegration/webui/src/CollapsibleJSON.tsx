import React, { useState } from 'react';
import './JsonData.css';

interface CollapsibleJSONProps {
  data: {
    [key: string]: any;
  };
}

const CollapsibleJSON: React.FC<CollapsibleJSONProps> = ({ data }) => {
  const [isOpen, setIsOpen] = useState(false);

  const toggleCollapse = () => {
    setIsOpen(!isOpen);
  };

  return (
    <div className="collapsible-json">
      <button className="collapse-button" onClick={toggleCollapse}>
        {isOpen ? '-' : '+'}
      </button>
      <div className="json-content">
        <span className="json-key">Reservation</span>
        {isOpen && (
          <ul>
            {Object.entries(data).filter(([key]) => !key.includes('_id')).map(([key, value]) => (
              <li key={key}>
                <strong>{key}: </strong>
                <span className="json-value">{value !== null ? value : <span className="null-value">null</span>}</span>
              </li>
            ))}
          </ul>
        )}
      </div>
    </div>
  );
};

export default CollapsibleJSON;
